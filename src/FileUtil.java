import java.io.*;

/**
 * @Auther: discat
 * @Email: distantcat@126.com
 * @Date: 2018-10-23 09:59
 * @Description: 文件处理
 */
public class FileUtil {
    public static void main(String[] args){
        bufferCoyeFIle("F://test.txt","F://result.txt");

        removeDir(new File("F://test"));

        splitFile("E://王牌1 Java SE 类库查询手册.pdf", "E://王牌1");

    }

    /*
        文件分割
     */
    private static void splitFile(String sourcePath, String targetPath){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(sourcePath);
            fos = null;
            byte[] bytes = new byte[1024*1024];
            int len;
            int count = 1;
            fos = new FileOutputStream(targetPath + (count++)+ ".part");
            int num = 1;
            while ((len = fis.read(bytes)) != -1) {
                fos.write(bytes, 0, len);
                if (num > 5) {
                    fos.close();
                    fos = new FileOutputStream(targetPath + (count++) + ".part");
                    num = 1;
                } else {
                    num++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /*
        删除文件夹
     */
    private static void removeDir(File dir) {
        File[] files = dir.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (!files[i].isHidden() && files[i].isDirectory()) {
                removeDir(files[i]);
            }else {
                System.out.println(files[i].getName()+ " --file-- "+ files[i].delete());
            }
        }
        System.out.println(dir.getName() +" --dir-- "+ dir.delete());
    }

    /*
        使用带缓冲功能的字节流复制文件
     */
    private static void bufferCoyeFIle(String sourcePath, String targerPath) {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            FileInputStream fis = new FileInputStream(sourcePath);
            bis = new BufferedInputStream(fis);
            FileOutputStream fos = new FileOutputStream(targerPath);
            bos = new BufferedOutputStream(fos);
            long len = bis.available();
            if (len > 1024*1024*200) {
                int b;
                while ((b = bis.read()) != -1) {
                    bos.write(b);
                }
                System.out.println("大文件复制");
            } else {
                byte[] byes = new byte[(int) len];
                bis.read(byes);
                bos.write(byes);
                System.out.println("小文件复制");
            }
            System.out.println("复制完成");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
