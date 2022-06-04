# LeetCode

[LeetCode官网地址](https://leetcode.com/problemset/algorithms/)

项目由来: 媳妇小组内有LeetCode活动, 每周需要完成一个LeetCode, 没有完成的需要请奶茶

为每个Problem创建一个单独的分支

### [寻找两个正序数组的中位数](https://leetcode.cn/problems/median-of-two-sorted-arrays/)
#### 二分查找
注意点：
> 1. 奇数和偶数的区别
> 2. 结束条件
>   * k=1时, 取最后一个值, 即两个数组中的当前位置的最小值即可
> 3. 边界判断
>   *  k / 2 和 k - k / 2, 此时无论k是奇数还是偶数都满足两个数的和为k
>   * 数量小的数组可能存在越界的情况, 需要注意: 数组长度和i + k / 2取最小
> 4. 小技巧
>   * 确保第一个是短数组
>   * 递归的时候如果第一个数组的长度长于第二个则进行交换

复杂度:
> 1. 时间复杂度: 每次缩短一半的长度: O(log(m + n))
> 2. 空间复杂度: O(1)