package alpha;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class greedy {

    public static void activity() {
        int start[]={1,3,0,5,8,5};
        int end[]={2,4,6,7,9,9};

        //sort activity on basis on end time
        int activity[][]=new int[start.length][3];
        for (int i = 0; i < activity.length; i++) {
            activity[i][0]=i;
            activity[i][1]=start[i];
            activity[i][2]=end[i];
        }

        Arrays.sort(activity,Comparator.comparingDouble(o->o[2]));


        //finding max activites;
        int maxact;
        ArrayList<Integer> al=new ArrayList<Integer>();

        al.add(activity[0][0]);
        maxact=1;
        int endtime=activity[0][2];

        for(int i=1;i<start.length;i++){
            if(activity[i][1 ]>=endtime){
                al.add(activity[i][0]);
                maxact++;
                endtime=activity[i][2];
            }
        }

        System.out.println(maxact);
    }

    public static void knapsack() {
        int weight[]={10,20,30};
        int value[]={60,100,120};
        int w=50;

        double ratio[][]=new double[value.length][2];
        for(int i=0;i<value.length;i++){
            ratio[i][0]=i;
            ratio[i][1]=value[i]/weight[i]*1.00;
        }

        Arrays.sort(ratio,Comparator.comparingDouble(o->o[1]));

        int cap=w;
        double val=0;
        for(int i=ratio.length-1;i>=0;i--){
            int idx=(int)ratio[i][0];
            if(cap>=weight[idx]){
                val+=value[idx];
                cap=cap-weight[idx];
            }else{
                val=val+(ratio[i][1]*cap);
                break;
            }
        }
        System.out.println(val);
        
    }

    public static void sumofdiff() {
        int a[]={4,1,8,7};
        int b[]={2,3,6,5};

        Arrays.sort(a);
        Arrays.sort(b);
        int diff=0;
        for(int i=0;i<a.length;i++){
            // if(a[i]<b[i]){
            //     diff=b[i]-a[i];
            // }else{
            //     diff=a[i]-b[i];
            // }
            // sum+=diff;
            diff+=Math.abs(a[i]-b[i]);
        }
        System.out.println(diff);
    }

    public static void maxchain() {
        int pairs[][]={{5,24},{39,60},{5,28},{27,40},{50,90}};

        Arrays.sort(pairs,Comparator.comparingDouble(o->o[1]));

        int chain=1;
        int lastend=pairs[0][1];

        for(int i=1;i<pairs.length;i++){
            if(pairs[i][0]>=lastend){
                chain++;
                lastend=pairs[i][1];
            }
        }
        System.out.println(chain);
    }

    public static void indiancoins() {
        int money[]={1,2,5,10,20,50,100,500,2000};
        int value=1059;
        int ans=0;
        ArrayList<Integer> list=new ArrayList<Integer>();
        for(int i=money.length-1;i>=0;i--){
            while(value/money[i]!=0){
                ans++;
                value-=money[i];
                list.add(money[i]);
            }
        }
        System.out.println(ans);
        System.out.println(list);
    }

    public static void job() {
        int job[][]={{4,20},{1,10},{1,40},{1,30}};

        Arrays.sort(job, Comparator.comparingDouble(o->o[1]));
        int time=0;
        int value=0;
        for(int i=job.length-1; i>=0;i--){
            if(job[i][0]>time){
                value+=job[i][1];
                time=job[i][0];
            }
        }

        System.out.println(value);

    }

    //important 
    public static void chocola() {
        Integer costh[]={2,1,3,1,4};
        Integer costv[]={4,1,2};

        Arrays.sort(costh , Collections.reverseOrder());
        Arrays.sort(costv , Collections.reverseOrder());

        int h=0;
        int v=0;
        int hp=1;
        int vp=1;
        int cost=0;
        while(h<costh.length && v<costv.length){
            if(costh[h]>=costv[v]){
                hp++;
                cost=cost+(vp*costh[h]);
                h++;
            }else{
                vp++;
                cost=cost+(hp*costv[v]);
                v++;
            }
        }

        while(h<costh.length){
            hp++;
            cost=cost+(vp*costh[h]);
            h++;
        }

        while(v<costv.length){
            vp++;
            cost=cost+(hp*costv[v]);
            v++;
        }

        System.out.println(cost);
    }
    public static void main(String[] args) {
        activity();
        knapsack();
        sumofdiff();
        maxchain();
        indiancoins();
        job();
        chocola();
    }
}
