package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import model.BoxArt;
import model.MovieList;
import util.DataUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
    Goal: Retrieve id, title, and a 150x200 box art url for every video
    DataSource: DataUtil.getMovieLists()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys", "boxart": BoxArt)
*/
public class Kata4 {
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();
        List<Map> lista1 = new ArrayList<>();
        lista1 = movieLists.stream()
                .flatMap(list -> list.getVideos().stream()
                        .map((movie) -> ImmutableMap.of(
                                "id: ", movie.getId(),
                                "title: ", movie.getTitle(),
                                "boxart: ", movie.getBoxarts().stream()
                                        .filter(boxArt -> {
                                            return boxArt.getWidth() == 150 || boxArt.getHeight() == 200;
                                        }).collect(Collectors.toList()))))
                .collect(Collectors.toList());
        return lista1;
    }
}
