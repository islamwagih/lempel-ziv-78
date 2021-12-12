import java.util.HashMap;

public class Compressor {
    public Compressor(){
    }
    public CompressedUnit compress(String toComp){
        HashMap<String, Integer> dict = new HashMap<>();
        int nextIdx = 1;
        if(toComp.length() < 1) return null;
        CompressedUnit toRet = new CompressedUnit();
        int i = 0;
        while(i < toComp.length()){
            String curr = toComp.charAt(i)+"";
            int j = i, idx = -1;
            while(dict.containsKey(curr) && j < toComp.length()){
                idx = dict.get(curr);
                j++;
                if(j < toComp.length()) curr+=toComp.charAt(j);
            }
            char nextSymbol = '#';
            if(j < toComp.length()){
                dict.put(curr, nextIdx);
                nextSymbol = curr.charAt(curr.length()-1);
                nextIdx++;
            }
            if(idx == -1) idx = 0;
            toRet.addTag(new Tag(idx, nextSymbol));
            i = j+1;
        }
        return toRet;
    }
    public String deCompress(CompressedUnit toDecomp){
        HashMap<Integer, String> dict = new HashMap<>();
        int nextIdx = 1;
        String key = "", toRet = "";
        for(Tag a:toDecomp.getTags()){
            if(a.getIndex() == 0){
                key = a.getNext()+"";
                dict.put(nextIdx, key);
            }else{
                key = dict.get(a.getIndex());
                if(a.getNext() != '#') key += a.getNext();
                dict.put(nextIdx, key);
            }
            nextIdx++;
            toRet += key;
        }
        return toRet;
    }
}
