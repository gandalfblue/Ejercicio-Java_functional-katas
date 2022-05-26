package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import model.Bookmark;
import model.BoxArt;
import model.Movie;
import model.MovieList;
import util.DataUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Retrieve the id, title, and smallest box art url for every video
    DataSource: DataUtil.getMovieLists()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys", "boxart": "url)
*/
public class Kata7 {
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();
        List<Map> lista1 = new ArrayList<>();
        lista1 = movieLists.stream()
                .flatMap(list -> list.getVideos().stream()
                        .map((movie) -> ImmutableMap.of(
                                "id: ", movie.getId(),
                                "title: ", movie.getTitle(),
                                "boxart: ", movie.getBoxarts().stream()
                                        .reduce((boxArt, boxArt2) ->{
                                            if(boxArt.getWidth() * boxArt.getHeight() > boxArt2.getWidth() * boxArt2.getHeight()){
                                                return boxArt;
                                            }
                                            return boxArt2;
                                        })))).collect(Collectors.toList());
        return lista1;
    }
}