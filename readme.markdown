这是lambda的一些学习demo
因为在工作中使用到的挺多的，所以打算再继续系统的学习一下吧

```java
List<String> list = new ArrayList<String>();
		list.add("I am a boy");
		list.add("I love the girl");
		list.add("But the girl loves another girl");
		List<String> copy = list.stream().map(e -> e.split(" ")).flatMap(Arrays::stream).distinct().collect(Collectors.toList());
```