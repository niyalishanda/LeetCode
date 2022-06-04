# LeetCode

[LeetCode官网地址](https://leetcode.com/problemset/algorithms/)

项目由来: 媳妇小组内有LeetCode活动, 每周需要完成一个LeetCode, 没有完成的需要请奶茶

为每个Problem创建一个单独的分支

### [合并K个升序链表](https://leetcode.cn/problems/merge-k-sorted-lists/)

#### 优先级队列

* 优先级队列的长度为链表的个数
  * 记录每个链表的队首元素
* 对优先级队列进行出队操作
* 出队的同时, 如果有next, 则将next添加到优先级队列中
* 出队完成即可获取排好序的队列

#### 复杂度

* 时间复杂度:
  * 优先级队列入队和出队的复杂度为: O(logk)
    * 节点数量假设为k*n
    * 每个节点都被插入和删除一次, 总复杂度为O(k*n logk)
* 空间复杂度:
  * 使用了优先级队列, 长度为k, 故复杂度为O(k)
