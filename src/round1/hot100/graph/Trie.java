package round1.hot100.graph;

public class Trie {
    // 实现 Trie 前缀树，类似于字典树 (多叉树)

    // 需要内部类来定义 Trie 的节点 TrieNode，否则回变为 26 叉树
    class TrieNode {
        // 节点需包含 isEnd 做为标识，同时和一个 next 数组
        boolean isEnd;
        TrieNode[] next;

        public TrieNode() {
            isEnd = false;
            next = new TrieNode[26];
        }
    }

    // Trie 对象里包含一个 TrieNode 节点
    private TrieNode root;

    public Trie() {
        // 初始化一个 TrieNode
        root = new TrieNode();
    }

    // 向前缀树中插入字符串 word
    public void insert(String word) {
        TrieNode curNode = root;
        // 遍历字符串
        // 插入字符串时，需要先判断 curNode.next[ch - 'a'] 是否已存在
        // 存在说明已有相同前缀的单词，无需新建节点
        // 不存在则新建节点
        // 记得移动指针，并在遍历字符串完成后标记结束位
        for (char ch : word.toCharArray()) {
            if (curNode.next[ch - 'a'] == null)
                curNode.next[ch - 'a'] = new TrieNode();
            curNode = curNode.next[ch - 'a'];
        }

        // 遍历完成后，标记结束
        curNode.isEnd = true;
    }

    // 如果字符串 word 在前缀树中，返回 true (即在检索之前已经插入)
    // 否则返回 false
    public boolean search(String word) {
        TrieNode curNode = root;
        // 与插入字符串不同的是
        // 搜索字符串在遍历字符串时，需要先移动 curNode 指针到 curNode.next[ch-'a']
        // 根节点本身没有存字母
        for (char ch : word.toCharArray()) {
            curNode = curNode.next[ch - 'a'];
            if (curNode == null)
                return false;
        }
        // 遍历完后看是否为结尾
        return curNode.isEnd;
    }

    // 如果之前已经插入的字符串 word 的前缀之一为 prefix，返回 true
    // 否则返回 false
    public boolean startsWith(String prefix) {
        // 同样先指向根节点
        TrieNode curNode = root;
        for (char ch : prefix.toCharArray()) {
            curNode = curNode.next[ch - 'a'];
            if (curNode == null)
                return false;
        }
        return true;
    }
}
