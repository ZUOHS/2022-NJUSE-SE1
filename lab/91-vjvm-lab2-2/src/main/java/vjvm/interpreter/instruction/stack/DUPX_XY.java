package vjvm.interpreter.instruction.stack;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.var;
import vjvm.interpreter.instruction.Instruction;
import vjvm.runtime.JThread;
import vjvm.runtime.OperandStack;
import vjvm.runtime.ProgramCounter;
import vjvm.runtime.Slots;
import vjvm.runtime.classdata.MethodInfo;

import java.util.function.BiConsumer;
import java.util.function.Function;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class DUPX_XY extends Instruction{
  private final Function<OperandStack, Slots> popFunc;
  private final Function<OperandStack, Slots> pop_Func;
  private final BiConsumer<OperandStack, Slots> pushFunc;
  private final BiConsumer<OperandStack, Slots> push_Func;
  private final String name;

  public static DUPX_XY DUP_1(ProgramCounter pc, MethodInfo method){
    return new DUPX_XY(s -> s.popSlots(1), s1 -> s1.popSlots(1),(s,t) -> s.pushSlots(t),(s1,t1) -> s1.pushSlots(t1), "dup_x1");
  }

  public static DUPX_XY DUP_2(ProgramCounter pc, MethodInfo method){
    return new DUPX_XY(s -> s.popSlots(1), s1 -> s1.popSlots(2),(s,t) -> s.pushSlots(t), (s1,t1) -> s1.pushSlots(t1),"dup_x2");
  }

  public static DUPX_XY DUP2_1(ProgramCounter pc, MethodInfo method){
    return new DUPX_XY(s -> s.popSlots(2), s1 -> s1.popSlots(1),(s,t) -> s.pushSlots(t), (s1,t1) -> s1.pushSlots(t1),"dup2_x1");
  }

  public static DUPX_XY DUP2_2(ProgramCounter pc, MethodInfo method){
    return new DUPX_XY(s -> s.popSlots(2), s1 -> s1.popSlots(2),(s,t) -> s.pushSlots(t), (s1,t1)  -> s1.pushSlots(t1),"dup2_x2");
  }

  @Override
  public void run(JThread thread) {
    var stack = thread.top().stack();
    var value = popFunc.apply(stack);
    var val = pop_Func.apply(stack);
    pushFunc.accept(stack, value);
    push_Func.accept(stack, val);
    pushFunc.accept(stack, value);
  }

  @Override
  public String toString() {
    return name;
  }
}
