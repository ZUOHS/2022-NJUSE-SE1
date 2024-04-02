package vjvm.interpreter.instruction.stack;

import lombok.var;
import vjvm.interpreter.instruction.Instruction;
import vjvm.runtime.JThread;
import vjvm.runtime.ProgramCounter;
import vjvm.runtime.classdata.MethodInfo;

public class POP1 extends Instruction {
  public POP1(ProgramCounter pc, MethodInfo method){
  }

  @Override
  public void run(JThread thread) {
    var stack = thread.top().stack();
    stack.popSlots(1);
  }

  @Override
  public String toString() {
    return "pop1";
  }
}
