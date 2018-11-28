package designpattern.mementopattern;

import java.util.List;

//记忆类（备忘录）
public class Memory {

    private List<String> storyList;

    public List<String> getStoryList() {
        return storyList;
    }

    public void setStoryList(List<String> storyList) {
        this.storyList = storyList;
    }

}
