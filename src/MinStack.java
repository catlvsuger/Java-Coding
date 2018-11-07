import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

/**
 * @Auther: discat
 * @Email: distantcat@126.com
 * @Date: 2018-09-28 11:04
 * @Description: 查询栈的最小值
 */
public class MinStack {
    private List<Integer> data = new ArrayList<>();
    private List<Integer> mins= new ArrayList<>(); //存储最小值索引

    public void push(int num) {
        data.add(num);
        if (mins.size() == 0) {
            //初始化mins
            mins.add(0);
        } else {
            //辅助栈mins push 最小值的索引
            int min = getMin();
            if (num < min) {
                mins.add(data.size() - 1);
            }
        }
    }

    public int pop() {
        //栈空，抛出异常
        if(data.size() == 0) {
            throw new EmptyStackException();
        }
        //pop先获取索引
        int popIndex = data.size()-1;
        //获取mins栈顶元素，它是最小值索引
        int minIndex = mins.get(mins.size()-1);
        //如果两个索引相等，删除mins存储的索引
        if (popIndex == minIndex) {
            mins.remove(mins.size()-1);
        }
        return  data.remove(data.size()-1);
    }

    public int getMin() {
        //栈空，抛出异常
        if (data.size() == 0) {
            throw  new EmptyStackException();
        }
        //获取mins栈顶元素，它是最小值索引
        int minIndex = mins.get(mins.size()-1);
        return data.get(minIndex);
    }

    //java的基础类型都是有符号类型，
    // 所以java的类型强转及类型提升都是有符号扩展（即在前边补符号位，符号位是1前边就都补1，是0就都补0）
    public static void main(String[] args) {
        //0x81看作是int型，最高位(第32位)为0，所以是正数
        System.out.println(0x81); //129

        //字面量0x80000001为int型，最高位(第32位)为1，所以是负数
        System.out.println(0x80000001);//-2147483647

        //只要超过32位，就需要在字面常量后加L强转long，否则编译时出错
        System.out.println(0x8000000000000000L);//-922337203685477
        MinStack minStack = new MinStack();
        minStack.push(5);
        minStack.push(3);
        minStack.push(2);
        minStack.push(4);
        System.out.println(minStack.getMin());
        minStack.push(1);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}
