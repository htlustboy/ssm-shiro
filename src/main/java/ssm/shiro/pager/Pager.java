package ssm.shiro.pager;/**
 * Created by taohu on 2019/11/20.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 分页
 *
 * @author taohu@maxxipoint.com
 * @prpgram ssm-shiro
 * @description
 * @create 2019/11/20 10:53:20
 */
public class Pager {

    private int pageSize = 10;
    private int pageNo;
    private int totalPageSize;
    private List<?> result;
    private HashMap<String, String> searchInfo = new HashMap<>();

    public int getPageSize() {
        return pageSize;
    }

    public int getPageNo() {
        return pageNo <= 0 ? 1 : pageNo;
    }

    public void setPageNo(int pageNo) {
        if (pageNo < 1 || pageNo > getTotalPageSize()) {
            this.pageNo = 1;
        } else {
            this.pageNo = pageNo;
        }
    }

    public Integer getTotalItems() {
        return result == null ? 0 : result.size();
    }

    public int getTotalPageSize() {
        if (getTotalItems() % pageSize == 0) {
            this.totalPageSize = getTotalItems() / pageSize;
        } else {
            this.totalPageSize = getTotalItems() / pageSize + 1;
        }
        return totalPageSize;
    }

    /**
     * 是否有下一页
     * @param pageNo
     * @return
     */
    public boolean isHasNext(int pageNo){
        return pageNo >= getTotalPageSize() ? false : true;
    }

    /**
     * 是否有上一页
     * @return
     */
    public boolean isHasPrev(int pageNo){
        return pageNo <= 1 ? false : true;
    }

    /**
     * 下一页
     * @param pageNo
     * @return
     */
    public int doNext(int pageNo){
        if(isHasNext(pageNo)){
            return pageNo + 1;
        }
        return pageNo;
    }

    /**
     * 上一页
     * @param pageNo
     * @return
     */
    public int doPrev(int pageNo){
        if(isHasPrev(pageNo)){
            return pageNo - 1;
        }
        return pageNo;
    }

    /**
     * 获取结果
     * @return
     */
    public List<?> getResult() {
        return result;
    }

    /**
     * 设置结果
     * @param result
     */
    public void setResult(List<?> result) {
        this.result = result;
    }

    /**
     * 首页
     * @return
     */
    public int getFirstPage(){
        return 1;
    }

    /**
     * 尾页
     * @return
     */
    public int getLastPage(){
        return getTotalPageSize();
    }


    public HashMap<String, String> getSearchInfo() {
        return searchInfo;
    }

    public void setSearchInfo(HashMap<String, String> searchInfo) {
        this.searchInfo = searchInfo;
    }

    //====================================================================================

    public Pager() {
        // TODO Auto-generated constructor stub
        this.pageNo = 1;
    }

    /**
     * @param pageNo 当前页
     */
    public Pager(int pageNo) {
        this.pageNo = pageNo;
    }

    public static void main(String[] args) {
        List<String> result = new ArrayList<>();
        result.add("abc1");
        result.add("abc2");
        result.add("abc3");
        result.add("abc4");
        result.add("abc5");
        result.add("abc6");
        result.add("abc7");
        result.add("abc8");
        result.add("abc9");
        result.add("abcA");
        result.add("abcB");
        Pager pager = new Pager(2);
        pager.setResult(result);
        System.out.println("当前页："+pager.getPageNo());
        System.out.println("总页数："+pager.getTotalPageSize());
        System.out.println("总记录数："+pager.getTotalItems());
        System.out.println("下一页："+pager.doNext(pager.getPageNo()));
        System.out.println("上一页："+pager.doPrev(pager.getPageNo()));
        System.out.println("首页："+pager.getFirstPage());
        System.out.println("尾页："+pager.getLastPage());
        System.out.println(result.subList(9,123));
    }
}
