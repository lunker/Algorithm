

public class Problem2{

  // 검색 단어 수
  public static int wordsNum=0;
  public static int sameMeaning=0;

  // 같은 의미를 가지는 단어들끼리 인접행렬 생성
  public static int[][] aMatrix=null;
  public static boolean[] visited=null;

  //같은 의미를 가지는 단어들간의 연관관계 생성 
  public static ArrayList[] outputList=null;

  // (검색단어, 검색횟수리스트) 저장.
  // 객체의 index가 해당 단어에 부여 된 식별 id
  public static SearchWord[] wordList=null;

  public static void main(String[] params){
    Scanner scanner=new Scanner(System.in);

    wordsNum=scanner.nextInt();
    aMatrix=new int[wordsNum][wordsNum];

    // 기본적으로 자신은 자신과 연관이 있다고 가정.
    // 다른 단어들과 연관이 없는 단어들은 본인과 연관이 있음.
    for(int row=0;row<wordsNum;row++){
        aMatrix[row][row]=1;
    }
    outputList=new ArrayList[wordsNum];
    for(int cnt=0;cnt<wordsNum;cnt++)
      outputList[cnt]=new ArrayList<Integer>();

    visited=new boolean[wordsNum];

    wordList=new SearchWord[wordsNum];

    scanner.nextLine(); //buffer 비움.
    // 검색단어, 검색 횟수 리스트 초기화.
    for(int cnt=0;cnt<wordNum;cnt++){
      String[] input=null;
      input=scanner.nextLine().split(",");
      wordList[cnt]=new SearchWord(input[0],input[1]);
    }

    // 같은 의미 단어 조합 수
    sameMeaning=scanner.nextInt();
    scanner.nextLine();//버퍼 비움.

    // 같은 의미를 가지는 단어들로 인접행렬 초기화.
    for(int cnt=0;cnt<sameMeaning;cnt++){
      String[] input=null;
      input=scanner.nextLine().split(",");
      int here=getWordIndex(input[0]);
      int there=getWordIndex(input[1]);
      if(here!=-1&&there!=-1){
        aMatrix[here][here]=0
        aMatrix[there][there]=0;
        aMatrix[here][there]=1;
        aMatrix[there][here]=1;
      }
    }

    // 시작점 0 초기화.
    visited[0]=true;
    findRepresentWord(0);
    printResult();
  }// end method
  public static int getWordIndex(Strin name){
    for(int idx=0;idx<wordsNum;idx++){
      if(wordList.getName().equals(name))
        return idx;
    }
    return -1;
  }

  /*
    깊이 우선 탐색 응용
  */
  public static void findRepresentWord(int here){

    for(int there=0;there<wordsNum;there++){
      if(aMatrix[here][there]==1&&!visited[there]){
        visited[there]=true;
        outputList[here].add(there);
        findRepresentWord(there);
      }
    }
  }

  public static void printResult(){
    int totalRepresentWordCnt=0;

    for(int cnt=0;cnt<wordsNum;cnt++){
      if(list.length()>0)
        totalRepresentWordCnt++;
    }
    System.out.println(totalRepresentWordCnt);
    for(int cnt=0;cnt<wordsNum;cnt++){
        ArraList<Integer> list= outputList[cnt];

        int searchCnt=0;
        int maxVal=Integer.MIN_VALUE;
        int maxIdx=0;

        if(list.length()>1){
          for(int idx=0;idx<list.length();idx++){
            int freq=list.get(idx).getCnt();
            searchCnt+=freq;

            // 연관 단어 중 대표 단어 검색
            if(maxVal<freq){
              maxIdx=idx;
              maxVal=freq;
            }
          }
          System.out.println(wordList[maxIdx].getName()+" , "+searchCnt);
        }
        //연관 관계가 없는 단어일 경우
        else if(list.length()==1){
          SearchWord alone=wordList[list.get(0)];
          System.out.println(alone.getName()+" , "+alone.getCnt());
        }

    }
  }
}
/*
  검색 단어 클래스
  name ; 상품명
  cnt ; 검색 횟수
*/
class SearchWord{

  private String name;
  private int cnt;

  public SearchWord(String name, int cnt){
    this.name=name;
    this.cnt=cnt;
  }
  public String getName(){return name;}
  public int getCnt(){return cnt;}
}
