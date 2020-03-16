## Lab3 心得与经验

总的来说，这次的 Lab3 对于我这样的初学者有点难度，特别是在IntList的反转部分，按照老师的提示看Dis03 的solution没有看懂，后面在网上搜才发现这是Leetcode 206 题，参考了讨论与题解，最后总算写出来了。这个题解写的很棒，链接贴在下面：
https://leetcode-cn.com/problems/reverse-linked-list/solution/dong-hua-yan-shi-206-fan-zhuan-lian-biao-by-user74/

1. 对于反转链表，有 iterative 和 recursive 两种解法，比较好理解的是 iterative，非常直观；recursive 不是很好理解，需要找到执行的最小单元，然后一层层地往外推，类似于剥洋葱，对于初学者来说需要花一点时间；
2. 第一题的 Arithmetic 错误很明显，没有花多少时间
3. 第三题的 Flik 问题，错误很隐蔽，在于 Interger 和 int 的区别。Interger 是有长度限制，所以还没到500次循环就shutdown了。用了print 大法，JUnit Test 不知道怎么用合适。在 Proj1a 中需要好好练一下。
