import java.util.Map;
import java.util.EnumMap;

//使用Map(起始阶段,Map(目标阶段，阶段过渡))形式代替使用序数组成二维数组的形式，这样更加利于维护。
public enum Phase {
    SOLID, LIQUID, GAS;
 
    public enum Transition {
       MELT(SOLID, LIQUID), FREEZE(LIQUID, SOLID),
       BOIL(LIQUID, GAS),   CONDENSE(GAS, LIQUID),
       SUBLIME(SOLID, GAS), DEPOSIT(GAS, SOLID);
 
       private final Phase src;
       private final Phase dst;
       //将转换所需要的值src为初始阶段，dst为目标阶段
       Transition(Phase src, Phase dst) {
          this.src = src;
          this.dst = dst;
       }
       // Initialize the phase transition map
       private static final Map<Phase, Map<Phase,Transition>> m =
         new EnumMap<Phase, Map<Phase,Transition>>(Phase.class);
       static {
          //放入初始阶段
          for (Phase p : Phase.values())
            m.put(p,new EnumMap<Phase,Transition>(Phase.class));
         //根据起始阶段的键放入目标阶段与状态的映射表
          for (Transition trans : Transition.values())
            m.get(trans.src).put(trans.dst, trans);
       }
 
       public static Transition from(Phase src, Phase dst) {
          //直接根据初始阶段获取映射再根据目标阶段获取过渡状态
          return m.get(src).get(dst);
       }
    }
 
    // Simple demo program - prints a sloppy table
    public static void main(String[] args) {
        for (Phase src : Phase.values())
            for (Phase dst : Phase.values())
                if (src != dst)
                    System.out.printf("%s to %s : %s %n", src, dst,
                                      Transition.from(src, dst));
    }
 }