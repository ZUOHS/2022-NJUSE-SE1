package vjvm.interpreter.instruction.stack;

import lombok.var;
import vjvm.interpreter.instruction.Instruction;
import vjvm.runtime.JThread;
import vjvm.runtime.ProgramCounter;
import vjvm.runtime.classdata.MethodInfo;

public class POP2 extends Instruction {
  public POP2(ProgramCounter pc, MethodInfo method){
  }

  @Override
  public void run(JThread thread) {
    var stack = thread.top().stack();
    stack.popSlots(2);
  }

  @Override
  public String toString() {
    return "pop2";
  }
}
