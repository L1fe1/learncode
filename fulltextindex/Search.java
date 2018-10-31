package fulltextindex;

import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;

public class Search {
    public static void main(String[] args) throws Exception {
      String indexPath = args[0], queryString = args[1];
      //指向索引目录的搜索器
//      Searcher searcher = new IndexSearcher(indexPath);
      //查询解析器：使用和索引同样的语言分析器
//      Query query = QueryParser.parse(queryString, "body",
//                                new SimpleAnalyzer());
      //搜索结果使用Hits存储
//      Hits hits = searcher.search(query);
      //通过hits可以访问到相应字段的数据和查询的匹配度
//      for (int i=0; i<hits.length(); i++) {
//        System.out.println(hits.doc(i).get("path") + "; Score: " +
//                           hits.score(i));
//      }
    }
  }