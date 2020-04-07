# Lab6 Experience

**Website:** https://sp19.datastructur.es/materials/lab/lab6/lab6

**Descrpition:** In this lab, you’ll create UnionFind which will be used to solve the dynamic connectivity problem.
As mentioned in discussion “Union Find” is a synonym for “Disjoint Sets”.

The Lab6 need us to write up an union-find algorithm. And my experiences are as followed:
1. Started with lecture code, Textbook *Algorithms (Fourth Edition)*, and the online data structural visualizer: https://www.cs.usfca.edu/~galles/visualization/DisjointSets.html
2. The algorithm that we need to implement is a little different from the textbook. More specifically, 
you'll need to consider how and where to change and store the set/tree/graph size.
3. The find() and sizeOf() functions will be a little tricky. Be aware to the signature and value of the parent/id array that you create.
4. For each method, remember to validate the input value.

Lab 6 的任务是需要自己完成一个 UnionFind 的算法，刚开始即便看完了视频，也不知道如何下手。
后面看课程网站的时候，发现从这里开始要看普林斯顿的红色算法书了，于是找到了书里面的1.5节，认真看懂了以后，这个lab也就做出来了。

以下是经验：
1. 在开始写这个lab之前，先自己看下课程ppt，普林斯段的*算法（第四版）*，以及在线数据结构网站：https://www.cs.usfca.edu/~galles/visualization/DisjointSets.html
2. 和书上的代码实现不同，作业要求用每一个 tree 的 root 来存储该树的 size（深度，并非节点数目），因此需要考虑在哪里对根节点的 parent 值进行改变
3. find() 方法和 Size() 稍微有点难度，关键在于对 parent[vertex] 值正负的判断
4. 在每一个方法中，要记得 validate 一下。

总的来说，这个 lab 花了大半天的时间。原以为要花两到三天。一方面是对 Java 语言熟练了，另一方面可以感觉自己的进步还是比较明显。继续加油！
