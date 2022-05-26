package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import model.Bookmark;
import model.InterestingMoment;
import model.Movie;
import model.MovieList;
import util.DataUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Retrieve each video's id, title, middle interesting moment time, and smallest box art url
    DataSource: DataUtil.getMovies()
    Output: List of ImmutableMap.of("id", 5, "title", "some title", "time", new Date(), "url", "someUrl")
*/
public class Kata9 {
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();

        List<Map> lista1 = new ArrayList<>();
        lista1 = movieLists.stream()
                .flatMap(list -> list.getVideos().stream()
                        .map((movie) -> ImmutableMap.of(
                                "id: ", movie.getId(),
                                "title: ", movie.getTitle(),
                                "time: ", movie.getInterestingMoments().stream()
                                                .map(InterestingMoment::getTime),
                                "url: ", movie.getBoxarts().stream()
                                        .reduce((boxArt, boxArt2) ->{
                                            if(boxArt.getWidth() * boxArt.getHeight() < boxArt2.getWidth() * boxArt2.getHeight()){
                                                return boxArt;
                                            }
                                            return boxArt2;
                                        })))).collect(Collectors.toList());
        return lista1;
    }
}
