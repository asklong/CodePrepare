//bonus：亚麻卖书，每本书都有与其关联性很强的书，给一个list<string,string> 代表书和与其关联的书，输出互相关联的最大集合。
//例如：三国演义 水浒传, 水浒传 红楼梦, 哈利波特 时间简史
//输出：
//三国演义，水浒传，红楼梦
//这题楼主的解法是和在undirect graph 找 largest connected components的思路是一样的。
	public List<String> getLargestConnectedComponents(List<Pair> bookPairs){
		Set<String> visited = new HashSet<>();
		Map<String, List<String>> edges = new HashMap<>();
		//for each book, we put the book and it's neighbors into the map
		for(int i=0; i<bookPairs.size(); ++i){
			edges.putIfAbsent(bookPairs.get(i).getBook1(), new ArrayList<String>());
			edges.putIfAbsent(bookPairs.get(i).getBook2(), new ArrayList<String>());
			edges.get(bookPairs.get(i).getBook1()).add(bookPairs.get(i).getBook2());
			edges.get(bookPairs.get(i).getBook2()).add(bookPairs.get(i).getBook1());
		}
		//for each book, we travel for the component
		List<String> books = new ArrayList<>();
		List<String> res = new ArrayList<>();
		for(String book: edges.keySet()){
			if(!visited.contains(book)){
				//each time we travel a new component, we record the component
				books.clear();
				dfs(visited, edges, book, books);
				if(res.size()<books.size()){
					res.clear();
					res.addAll(books);
				}
			}
		}
		return res;
	}
	public void dfs(Set<String> visited, Map<String, List<String>> edges, String book, List<String>books){
		//if we didn't visit the book, we could go far
		if(!visited.contains(book)){
			visited.add(book);
			books.add(book);
			//go to it's unvisited neighbor
			for(String neighborBook: edges.get(book)){
				dfs(visited, edges, neighborBook, books);
			}
		}
	}
