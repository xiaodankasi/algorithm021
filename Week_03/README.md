## 学习笔记-Week3

### 递归 Recursion

剥洋葱、盗梦空间的类比理解

#### 代码模板

``` java
public void recur (int levle, int param){
    
    // terminator
    if(level > MAX_LEVEL){
        // Process result
        retrun;
    }
    
    // process current logic
    process( level,param);
    
    // drill down
    recur(level+1;newParam);
    
    // restore current status

}
```

#### 思维要点

1. 不要人肉进行递归(最大误区)，即抵制人肉递归思维

2. 找到最近最简方法，将其拆解成可重复解决的问题，即找重复子问题

3. 数学归纳反思维

4. 解决递归问题脑海中浮现代码模板四大步

### 分治

分治：分解子问题，求解子问题，合并子问题

#### 代码模板

``` python
    def divide_conquer(problem, param1, param2, ...):
      # recursion terminator
      if problem is None:
        print_result
        return
      # prepare data
      data = prepare_data(problem)
      subproblems = split_problem(problem, data)
      # conquer subproblems
      subresult1 = self.divide_conquer(subproblems[0], p1, ...)
      subresult2 = self.divide_conquer(subproblems[1], p1, ...)
      subresult3 = self.divide_conquer(subproblems[2], p1, ...)
      ...
      # process and generate the final result
      result = process_result(subresult1, subresult2, subresult3, …)
      # revert the current level states
```

如何拆解子问题，如何merge子问题处理结果

### 回溯 BackTracking

回溯法采用试错的思想，它采用分步的去解决一个问题。在分步解决问题的过程中，当它通过尝试发现现有的分步答案不能得到有效的正确的解答的时候，它将取消上一步甚至是上几步的计算，再通过其他的可能的分步解答再次尝试寻找问题的答案。

**归去来兮**