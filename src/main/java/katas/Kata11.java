package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import util.DataUtil;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Create a datastructure from the given data:

    This time we have 4 seperate arrays each containing lists, videos, boxarts, and bookmarks respectively.
    Each object has a parent id, indicating its parent.
    We want to build an array of list objects, each with a name and a videos array.
    The videos array will contain the video's id, title, bookmark time, and smallest boxart url.
    In other words we want to build the following structure:

    [
        {
            "name": "New Releases",
            "videos": [
                {
                    "id": 65432445,
                    "title": "The Chamber",
                    "time": 32432,
                    "boxart": "http://cdn-0.nflximg.com/images/2891/TheChamber130.jpg"
                },
                {
                    "id": 675465,
                    "title": "Fracture",
                    "time": 3534543,
                    "boxart": "http://cdn-0.nflximg.com/images/2891/Fracture120.jpg"
                }
            ]
        },
        {
            "name": "Thrillers",
            "videos": [
                {
                    "id": 70111470,
                    "title": "Die Hard",
                    "time": 645243,
                    "boxart": "http://cdn-0.nflximg.com/images/2891/DieHard150.jpg"
                },
                {
                    "id": 654356453,
                    "title": "Bad Boys",
                    "time": 984934,
                    "boxart": "http://cdn-0.nflximg.com/images/2891/BadBoys140.jpg"
                }
            ]
        }
    ]

    DataSource: DataUtil.getLists(), DataUtil.getVideos(), DataUtil.getBoxArts(), DataUtil.getBookmarkList()
    Output: the given datastructure
*/
public class Kata11 {
    public static List<Map> execute() {
        List<Map> lists = DataUtil.getLists();
        List<Map> videos = DataUtil.getVideos();
        List<Map> boxArts = DataUtil.getBoxArts();
        List<Map> bookmarkList = DataUtil.getBookmarkList();

        return lists.stream()
                .map(list -> ImmutableMap.of("name", getUrl(list, "name"), "videos",
                        videos.stream().filter(video -> isValidateVideosList(video, "listId", getUrl(list, "id")))
                                .map(video -> ImmutableMap.of("id", getUrl(video, "id"), "title", getUrl(video, "title"),
                                        "time", getTime(getUrl(video, "id"), bookmarkList), "boxart",
                                        boxArts.stream().filter(box -> isValidateVideosList(video, "id", getUrl(box, "videoId")))
                                                .min(getMapComparator())
                                                .map(boxArt -> getUrl(boxArt, "url")).orElse("")))
                                .collect(Collectors.toList())))
                .collect(Collectors.toList());
    }

    private static boolean isValidateVideosList(Map video, String id, Object box) {
        return validateVideosList(video, id, box);
    }

    private static Comparator<Map> getMapComparator() {
        return Comparator.comparingInt(Kata11::getBoxArea);
    }

    private static int getBoxArea(Map o2) {
        return (Integer) getUrl(o2, "width") * (Integer) getUrl(o2, "height");
    }

    private static Object getUrl(Map boxArt, String url) {
        return boxArt.get(url);
    }

    private static boolean validateVideosList(Map video, String listId, Object list) {
        return getUrl(video, listId).equals(list);
    }

    private static Object getTime(Object videoId, List<Map> bookmarkList) {
        return bookmarkList.stream().filter(bookmark -> isValidateVideosList(bookmark, "videoId", videoId))
                .map(bookmark -> getUrl(bookmark, "time")).findFirst().orElse(null);
    }
}
