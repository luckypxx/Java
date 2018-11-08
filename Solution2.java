package leetcode;

class Solution2 {
    public int romanToInt(String s) {
        int result = 0;
        int flag1 = 1;
        int flag2 = 1;
        if(!(s.endsWith("I"))){
            flag1 = -1;
        }else{
            flag1 = 1;
        }
        if(!(s.endsWith("X"))){
            flag2 = -1;
        }else{
            flag2 = 1;
        }
        String value = "MDCLX";
        if(s.length() == 1){
            return retValue(s.charAt(0));
        }
        //算加法
        if(s.contains("M")||s.contains("D")||s.contains("C")||s.contains("L")||s.contains("X")){

            for(int i = 0;i<value.length();++i){

                if(s.contains(value.charAt(i) + "")){
                    while(s.contains(value.charAt(i) + "")){

                        result += retValue(value.charAt(i));

                        s = s.replaceFirst(value.charAt(i) + ""," ");
                    }
                    s = s.trim();
                    String[] data = s.split(" ");

                    s = s.replace(" ","");
                    //减去单独存在的字符
                    if(!((data[0].length() == 1) && (data.length == 1))) {
                        /**for(int j = 0;j < data.length;++j){
                            if(data[j].length() == 1) {
                                if (!(("I".equals(data[j])) || ("V".equals(data[j])))) {
                                    result -= retValue(data[j].charAt(0));
                                    s = s.replace(data[j].charAt(0) + "", "");
                                    data[j] = null;
                                }
                            }
                        }*/
                        if(data[0].length() == 1) {
                            if (!(("I".equals(data[0])) || ("V".equals(data[0])))) {
                                result -= retValue(data[0].charAt(0));
                                s = s.replace(data[0].charAt(0) + "", "");
                                data[0] = null;
                            }
                        }
                    }else{
                        if("I".equals(data[0])){

                            result += flag1*retValue(data[0].charAt(0));

                        }else if("X".equals(data[0])){
                            result += flag2*retValue(data[0].charAt(0));
                        }else{
                            result += retValue(data[0].charAt(0));
                        }
                        s = s.replace(data[0].charAt(0) + "", "");
                        data[0] = null;
                    }
                    for(String temp:data){
                        if(temp != null){
                            s = "";
                        }
                    }

                    //更新字符串
                    for(int m = 0; m < data.length;++m){

                        if(data[m] != null){

                            s += data[m];
                        }else if("".equals(data[m])){
                            return result;
                        }
                    }
                }
            }
        }

        if(s.startsWith("V")){
            result = result + 5 + s.length() - 1;
        }else if(s.endsWith("V")){
            result = result + 5 - s.length() + 1;
        }else{
            if(s.startsWith("I")){
                result += flag1*s.length();
            }else{
                result += s.length();
            }

        }
        return result;
    }

    public int retValue(char val){
        switch(val)
        {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.println(s.romanToInt("MCM"));
    }
}

