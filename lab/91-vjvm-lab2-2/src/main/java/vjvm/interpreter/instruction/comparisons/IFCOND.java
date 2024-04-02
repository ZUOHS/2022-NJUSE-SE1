package vjvm.interpreter.instruction.comparisons;

import lombok.var;
import vjvm.interpreter.instruction.Instruction;
import vjvm.runtime.JThread;
import vjvm.runtime.ProgramCounter;
import vjvm.runtime.classdata.MethodInfo;

public class IFCOND extends Instruction {
  private final BiIntPredicate pred;
  private final String name;
  private final int offset;

  private IFCOND(BiIntPredicate pred, String name, ProgramCounter pc) {
    this.pred = pred;
    this.name = name;
    this.offset = pc.short_() - 3;
  }

  public static IFCOND IFEQ(ProgramCounter pc, MethodInfo method) {
    return new IFCOND((x, y) -> x == y, "ifeq", pc);
  }

  public static IFCOND IFNE(ProgramCounter pc, MethodInfo method) {
    return new IFCOND((x, y) -> x != y, "ifne", pc);
  }

  public static IFCOND IFLT(ProgramCounter pc, MethodInfo method) {
    return new IFCOND((x, y) -> x < y, "iflt", pc);
  }

  public static IFCOND IFLE(ProgramCounter pc, MethodInfo method) {
    return new IFCOND((x, y) -> x <= y, "ifle", pc);
  }

  public static IFCOND IFGT(ProgramCounter pc, MethodInfo method) {
    return new IFCOND((x, y) -> x > y, "ifgt", pc);
  }

  public static IFCOND IFGE(ProgramCounter pc, MethodInfo method) {
    return new IFCOND((x, y) -> x >= y, "ifge", pc);
  }

  @Override
  public void run(JThread thread) {
    var stack = thread.top().stack();
    var left = stack.popInt();
    var pc = thread.pc();
    if (pred.test(left, 0))pc.move(offset);
  }

  @Override
  public String toString() {
    return String.format("%s %d", name, offset);
  }
}

