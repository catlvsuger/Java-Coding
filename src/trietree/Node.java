package trietree;

/**
 * @Auther: discat
 * @Email: distantcat@126.com
 * @Date: 2018-10-10 16:49
 * @Description:
 */

public class Node {
    private String name; //结点的字符名称
    private int fre; //单词词频
    private boolean end; //是否是单词结尾
    private boolean root; //是否根结点
    private Node[] children; //子节点信息
    private boolean visited; //是否已经遍历
    private int minLength; //通过该节点的最小数字长度
    private int prefixcount = 0; //有多少单词通过这个节点
    private Node parent;

    public Node() {
    }

    public Node(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFre() {
        return fre;
    }

    public void setFre(int fre) {
        this.fre = fre;
    }

    public boolean isEnd() {
        return end;
    }

    public void setEnd(boolean end) {
        this.end = end;
    }

    public boolean isRoot() {
        return root;
    }

    public void setRoot(boolean root) {
        this.root = root;
    }

    public Node[] getChildren() {
        return children;
    }

    public void setChildren(Node[] children) {
        this.children = children;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public int getMinLength() {
        return minLength;
    }

    public void setMinLength(int minLength) {
        this.minLength = minLength;
    }

    public int getPrefixcount() {
        return prefixcount;
    }

    public void setPrefixcount(int prefixcount) {
        this.prefixcount = prefixcount;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }
}
