


/*
  하나의 상자에 1개의 상품만 담을 수 있을 경우,
  최소한의 이동거리는 각 상품까지의 거리를 오름차순으로 정렬하여
  가까이 있는 상품들 부터 포장하는 경우이다.

  따라서, 주문 사항들을 입력받아
  이를 각 상품의 위치에 따라 정렬하여 3개씩 그룹핑한다.
*/
public class Problem3First{

  public static ArrayList<Order> orderList=null;
  public static Order[] orderedOrderArr=null;

  public static void main(String[] params){

    orderList=new ArrayList<Order>();

    /*
      입력을 통해 고객의 주문 사항을 입력받는다.
    */
    String customer="";
    int product=0;

    orderList.add(new Order(customer,product));
    sortOrderList();
    grouping();
  }// end method

  // 상품까지의 거리(위치)로 오름차순 정렬
  public static void sortOrderList(){
    orderedOrderArr=orderList.toArray();

    for(int cnt=0;cnt<orderedOrderArr.length-1;cnt++){
      for(int go=0;go<orderedOrderArr.length-1-cnt){
        if(orderedOrderArr[go].getProduct>orderedOrderArr[go+1].getProduct()){
          Order tmp=orderedOrderArr[go];
          orderedOrderArr[go]=orderedOrderArr[go+1];
          orderedOrderArr[go+1]=tmp;
        }
      }
    }
  }
  public static void grouping(){
    int group=0;
    int groupSize=3;
    int boxCnt=0;
    for(Order order : orderedOrderArr){
      if(group%box==0){
        group++;
        Sysetm.out.print("그룹 "+group+":");
      }
      boxCnt++;
      System.out.print("상자"+boxCnt+"("+order.getCustomer()+order.getProduct+"), ");
      if(boxCnt%3==0)
        System.ou.t.println();
    }
  }
}

class Order{
  String customer;
  int product;

  public Order(String customer, int product){
    this.customer=customer;
    this.product=product;
  }

  public String getCustomer(){return customer;}
  public int getProduct(){return product;}
}
