package fulltextindex;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexWriter;

public class IndexFiles {
    //使用方法：: IndexFiles [索引输出目录] [索引的文件列表] ... 
    public static void main(String[] args) throws Exception {
      String indexPath = args[0];
      IndexWriter writer;
      //用指定的语言分析器构造一个新的写索引器（第3个参数表示是否为追加索引）
//      writer = new IndexWriter(indexPath, new SimpleAnalyzer(), false);
  
      for (int i=1; i<args.length; i++) {
        System.out.println("Indexing file " + args[i]);
        InputStream is = new FileInputStream(args[i]);
  
        //构造包含2个字段Field的Document对象
        //一个是路径path字段，不索引，只存储
        //一个是内容body字段，进行全文索引，并存储
        Document doc = new Document();
//        doc.add(Field.UnIndexed("path", args[i]));
//        doc.add(Field.Text("body", (Reader) new InputStreamReader(is)));
        //将文档写入索引
//        writer.addDocument(doc);
        is.close();
      };
      //关闭写索引器
//      writer.close();
    }
  }