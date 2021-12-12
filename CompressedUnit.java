import java.util.ArrayList;
public class CompressedUnit {
    private ArrayList<Tag> tags = new ArrayList<Tag>();
    private int bitsNeeded(int num){
        if(num == 0) return 1;
        int cnt = 0;
        while(num > 0){
            cnt++;
            num/=2;
        }
        return cnt;
    }
    public void addTag(Tag toAdd){
        tags.add(toAdd);
    }
    public ArrayList<Tag> getTags(){
        return tags;
    }
    public int getTagSize(){
        int mx = 0;
        for(Tag a:tags){
            int bitsForIdx = bitsNeeded(a.getIndex());
            if(bitsForIdx > mx) mx = bitsForIdx;
        }
        return mx+8;
    }

    public int getCompresionSize(){
        return getTagSize()*tags.size();
    }
}
