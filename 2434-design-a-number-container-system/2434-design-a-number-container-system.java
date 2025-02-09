class NumberContainers {
    HashMap<Integer,TreeSet<Integer>> numberToIdx;
    HashMap<Integer,Integer> idxToNumber;
    public NumberContainers() {
        numberToIdx = new HashMap<>();
        idxToNumber = new HashMap<>();
    }
    
    public void change(int index, int number) {
        // delete old
        if(idxToNumber.containsKey(index)){
            int prev = idxToNumber.get(index);
            numberToIdx.get(prev).remove(index);
            if(numberToIdx.get(prev).size()==0){
                numberToIdx.remove(prev);
            }
        }
        // insert new
        idxToNumber.put(index,number);
        if(!numberToIdx.containsKey(number)){
            numberToIdx.put(number, new TreeSet<>());
        }
        numberToIdx.get(number).add(index);
    }
    
    public int find(int number) {
        if(!numberToIdx.containsKey(number)){
            return -1;
        }
        return numberToIdx.get(number).first();
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */