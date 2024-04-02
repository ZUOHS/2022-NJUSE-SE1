package vjvm.interpreter.instruction.constants;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.var;
import vjvm.interpreter.instruction.Instruction;
import vjvm.runtime.JThread;
import vjvm.runtime.OperandStack;
import vjvm.runtime.ProgramCounter;
import vjvm.runtime.classdata.MethodInfo;
import vjvm.runtime.classdata.constant.DoubleConstant;
import vjvm.runtime.classdata.constant.FloatConstant;
import vjvm.runtime.classdata.constant.IntegerConstant;
import vjvm.runtime.classdata.constant.LongConstant;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class LDCX extends Instruction {
  private final Object value;
  private String name;

  public static final LDCX LDC(ProgramCounter pc, MethodInfo method) {
    return new LDCX(method.jClass().constantPool().constant(pc.ubyte()), "ldc");
  }

  public static final LDCX LDC_W(ProgramCounter pc, MethodInfo method) {
    return new LDCX(method.jClass().constantPool().constant(pc.ushort()), "ldc_w");
  }

  public static final LDCX LDC2(ProgramCounter pc, MethodInfo method) {
    return new LDCX(method.jClass().constantPool().constant(pc.ushort()), "ldc2");
  }

  private void judge(Object object, OperandStack stack){
    if (object.toString().startsWith("I")){
      stack.pushInt(((IntegerConstant)object).value());
    }
    else if(object.toString().startsWith("L")){
      stack.pushLong(((LongConstant) object).value());
    }
    else if (object.toString().startsWith("F")) {
      stack.pushFloat(((FloatConstant) object).value());
    }
    else if (object.toString().startsWith("D")){
      stack.pushDouble(((DoubleConstant) object).value());
    }
  }

  @Override
  public void run(JThread thread) {
    var stack = thread.top().stack();
    judge(value, stack);
  }

  @Override
  public String toString() {
    return name;
  }
}
