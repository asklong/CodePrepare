// find the k movies, that is near for the input movie.

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MovieSearch {
	public List<Integer> find(int id, int k, Movie movie) {
		//the list is used to keep the result
		List<Integer> res = new ArrayList<>();
		//to avoid the repeated movies, we should use a set
		HashSet<Integer> visited = new HashSet<>();
		//create the priority queue to keep the largest k movies
		PriorityQueue<Movie> minHeap = new PriorityQueue<>((a,b)->{
			return a.rate-b.rate;
		});
		//create a queue to travel the graph by bfs
		Queue<Movie> q = new LinkedList<>();
		//we put the first movie to the queue
		q.offer(movie);
		
		while(!q.isEmpty()){
			//visit the movie
			Movie m = q.poll();
			//check all it's neighbors
			for(Movie neighborMovie: m.neighbors){
				if(!visited.contains(neighborMovie.id)){
					visited.add(neighborMovie.id);
					//then put the movie into the queue, and move the movie with the smallest rate
					minHeap.offer(neighborMovie);
					if(minHeap.size()>k){
						//if the size is larger than k, remove the least element
						minHeap.poll();
					}
					q.offer(neighborMovie);
				}
			}
		}
		while(!minHeap.isEmpty()){
			res.add(minHeap.poll().id);
		}
		return res;
	}

	class Movie {
        int id;
        int rate;
        List<Movie> neighbors;

        public Movie(int id, int rate, List<Movie> neighbors) {
            this.id = id;
            this.rate = rate;
            this.neighbors = neighbors;
        }
    }
}
