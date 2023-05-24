package org.java.best.controller;

import java.util.ArrayList;
import java.util.List;

import org.java.best.obj.Movie;
import org.java.best.obj.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MoviesSongController {
	
	private List<Movie> getBestMovies(){
		List<Movie> movieList = new ArrayList<>();
		for(int i = 0; i<3; i++) {
			Movie movie = new Movie(i+1, "movie " + (i+1));
			movieList.add(movie);
		}
		return movieList;
	}
	
	private List<Song> getBestSongs(){
		List<Song> songList = new ArrayList<>();
		for(int i = 0; i<3; i++) {
			Song song = new Song(i+1, "song " + (i+1));
			songList.add(song);
		}
		return songList;
	}

	@GetMapping("/")
	public String getHome(Model model, @RequestParam(name = "name") String name) {
		
		model.addAttribute("name", name);
		
		return "home";
	}
	
	@GetMapping("/movies")
	public String getMovies(Model model) {
		
		String moviesList = "";
		List<Movie> movies = getBestMovies();
		
		for(int i = 0; i<movies.size(); i++) {
			if (i<movies.size()-1) {
				moviesList += movies.get(i).getTitle() + ", ";
			} else {
				moviesList += movies.get(i).getTitle() + ".";
			}
		}
		
		model.addAttribute("moviesList", moviesList);
		
		return "movies";
	}
	
	@GetMapping("/songs")
	public String getSongs(Model model) {
		
		String songsList = "";
		List<Song> songs = getBestSongs();
		
		for(int i = 0; i<songs.size(); i++) {
			if (i<songs.size()-1) {
				songsList += songs.get(i).getTitle() + ", ";
			} else {
				songsList += songs.get(i).getTitle() + ".";
			}
		}
		
		model.addAttribute("songsList", songsList);
		
		return "songs";
	}
	
	@GetMapping("/movies/{id}")
	public String getMovieDetail(Model model, @PathVariable("id") long id) {
		
		List<Movie> movies = getBestMovies();
		String movie = null;
		
		for(int i = 0; i<movies.size(); i++) {
			if(id == movies.get(i).getId()) {
				movie = movies.get(i).getTitle();
				break;
			}
		}
		
		model.addAttribute("movie", movie);
		
		return "moviedetails";
	}
	
	@GetMapping("/songs/{id}")
	public String getSongDetail(Model model, @PathVariable("id") long id) {
		
		List<Song> songs = getBestSongs();
		String song = null;
		
		for(int i = 0; i<songs.size(); i++) {
			if(id == songs.get(i).getId()) {
				song = songs.get(i).getTitle();
				break;
			}
		}
		
		model.addAttribute("song", song);
		
		return "songdetails";
	}
}
