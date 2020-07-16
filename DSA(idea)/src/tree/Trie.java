package tree;

import java.util.ArrayList;
import java.util.List;

/**
 *Trie树的实现
 *@author wxisme
 *@time 2015-10-13 下午9:48:30
 */
public class Trie {

    private final int SIZE = 26;//字符出现的种类数,以所有的小写字母为例

    private int nodeNumber;//子节点的个数

    private int depth;//树的深度

    private TrieNode root;//树根

    public Trie() {
        this.nodeNumber = 0;
        this.depth = 0;
        this.root = new TrieNode();
    }

    /**
     * 节点结构
     * @author wxisme
     *
     */
    private class TrieNode {
        private char val;//节点值

        private TrieNode son[];//子节点数组

        private boolean isEnd;//是否有以此节点为结束字符的单词

        private int pearNumber;//节点出现的次数

        public TrieNode() {
            this.isEnd = false;
            this.pearNumber = 0;
            this.son = new TrieNode[SIZE];
        }
    }

    /**
     * 向Trie中插入一个word
     * @param word
     */
    public void insert(String word) {
        char[] wordChars = word.toCharArray();

        TrieNode node = this.root;

        for(char ch : wordChars) {
            int pos = ch - 'a';
            //如果相应位置为空则创建
            if(node.son[pos] == null) {
                node.son[pos] = new TrieNode();
                node.son[pos].val = ch;
                node.pearNumber = 1;//第一次出现
                this.nodeNumber ++;
            }
            else {//已经有该字符
                node.pearNumber ++;
            }
            node = node.son[pos];
        }
        node.isEnd = true;
        this.depth = Math.max(this.depth, word.length());
    }

    /**
     * 查找是否存在单词word
     * @param word
     * @return 结果
     */
    public boolean search(String word) {
        char[] wordChars = word.toCharArray();

        TrieNode node = this.root;

        for(char ch : wordChars) {
            int pos = ch - 'a';
            if(node.son[pos] != null) {
                node = node.son[pos];//继续向下查找
            }
            else {
                return false;
            }
        }

        return node.isEnd;
    }

    /**
     * 找到 sentence 中以 endPos 为结尾的单词，返回这些单词的开头下标。
     * @param sentence
     * @param endPos
     * @return
     */
    public List<Integer> search(String sentence, int endPos) {
        List<Integer> indices = new ArrayList<>();
        TrieNode cur = root;
        for (int i = endPos; i >= 0; i--) {
            int c = sentence.charAt(i) - 'a';
            if (cur.son[c] == null) {
                break;
            }
            cur = cur.son[c];
            if (cur.isEnd) {
                indices.add(i);
            }
        }
        return indices;
    }


    /**
     * 查找是否存在以word为前缀的单词，和search()类似，只是不用判断边界。
     * @param word
     * @return 结果
     */
    public boolean searchPrefix(String word) {
        char[] wordChars = word.toCharArray();

        TrieNode node = this.root;

        for(char ch : wordChars) {
            int pos = ch - 'a';
            if(node.son[pos] != null) {
                node = node.son[pos];//继续向下查找
            }
            else {
                return false;
            }
        }

        return true;
    }

    /**
     * 统计单词出现的次数
     * @param word
     * @return 结果
     */
    public int wordCount(String word) {
        char[] wordChars = word.toCharArray();

        TrieNode node = this.root;

        for(char ch : wordChars) {
            int pos = ch - 'a';
            if(node.son[pos] == null) {
                return 0;
            }
            else {
                node = node.son[pos];
            }
        }

        return node.isEnd?node.pearNumber:0;
    }


    /**
     * 统计以word为前缀的单词个数
     * @param word
     * @return 结果
     */
    public int wordPrefixCount(String word) {
        char[] wordChars = word.toCharArray();

        TrieNode node = this.root;

        for(char ch : wordChars) {
            int pos = ch - 'a';
            if(node.son[pos] == null) {
                return 0;
            }
            else {
                node = node.son[pos];
            }
        }

        return node.pearNumber;
    }

    /**
     * 深度优先遍历Trie树
     * @param root
     */
    public void traversal(TrieNode root) {
        if(root == null) {
            return;
        }
        for(TrieNode node : root.son) {
            System.out.println(node.val);
            traversal(node);
        }
    }

    public int getNodeNumber() {
        return nodeNumber;
    }

    public int getDepth() {
        return depth;
    }

    public TrieNode getRoot() {
        return root;
    }

}