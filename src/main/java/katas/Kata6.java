package katas;

import model.BoxArt;
import model.Movie;
import util.DataUtil;

import java.util.List;
import java.util.stream.Stream;

/*
    Goal: Retrieve the url of the largest boxart using map() and reduce()
    DataSource: DataUtil.getMovieLists()
    Output: String
*/
public class Kata6 {
    public static String execute() {
        List<Movie> movies = DataUtil.getMovies();
        String url = movies.stream().
                map(movie -> {
                    return movie.getBoxarts().stream()
                            .reduce((boxArt, boxArt2) -> {

                                if (boxArt.getWidth() >= boxArt2.getWidth()) {
                                    return boxArt;
                                }
                                return boxArt2;
                            })
                            .map(BoxArt::getUrl);
                }).toString();
        return url;
    }
}
