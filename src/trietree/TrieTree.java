package trietree;

/**
 * @Auther: discat
 * @Email: distantcat@126.com
 * @Date: 2018-10-10 16:47
 * @Description:
 */
public class TrieTree {
    Node root;
    int depth;

    //初始化 新的字典树
    public TrieTree(String name) {
        root = new Node(name);
        root.setFre(0);
        depth = 0;
        root.setEnd(false);
        root.setRoot(true);
    }

    public void insert(String number) {
        Node node = root;
        char[] numberCells = number.toCharArray();
        for (int i = 0; i < numberCells.length; i++) {
            int num = Integer.parseInt(String.valueOf(numberCells[i]));
            if (node.getChildren()[num] != null) {
                if (numberCells.length < node.getChildren()[num].getMinLength()) {
                    node.getChildren()[num].setMinLength(numberCells.length);
                }
                if (i == numberCells.length-1) {
                    Node endNode = node.getChildren()[num];
                    endNode.setFre(endNode.getFre() + 1);
                    endNode.setEnd(true);
                }
                //node.getChildren()[num].pre
            }
        }
    }

}
