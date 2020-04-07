# Lab6 Experience

**Website:* https://sp19.datastructur.es/materials/lab/lab6/lab6
**Descrpition:** In this lab, you’ll create UnionFind which will be used to solve the dynamic connectivity problem.
As mentioned in discussion “Union Find” is a synonym for “Disjoint Sets”.

The Lab6 need us to write up an union-find algorithm. And my experiences are as followed:
1. Started with lecture code, Textbook *Algorithms (Fourth Edition)*, and the online data structural visualizer: https://www.cs.usfca.edu/~galles/visualization/DisjointSets.html
2. The algorithm that we need to implement is a little different from the textbook. More specifically, 
you'll need to consider how and where to change and store the set/tree/graph size.
3. The find() and sizeOf() functions will be a little tricky. Be aware to the signature and value of the parent/id array that you create.
4. For each method, remember to validate the input value.
