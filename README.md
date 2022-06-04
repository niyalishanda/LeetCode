# LeetCode

[LeetCode官网地址](https://leetcode.com/problemset/algorithms/)

项目由来: 媳妇小组内有LeetCode活动, 每周需要完成一个LeetCode, 没有完成的需要请奶茶

为每个Problem创建一个单独的分支

### [二叉树中的最大路径和](https://leetcode.cn/problems/binary-tree-maximum-path-sum/)

### DFS

#### 注意点

* ans的初始化, 需要初始化为最小值Integer.MIN_VALUE
* ans的取值为ans和Math.max(ans, node.value + right + left);
* 递归的返回值为 Math.max(left, right) + node.val, 每个节点只能经过一次

#### 复杂度分析

* 时间复杂度: O(n)
* 空间复杂度: O(n)
