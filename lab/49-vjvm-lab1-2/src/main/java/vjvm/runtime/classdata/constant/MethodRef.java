package vjvm.runtime.classdata.constant;

import lombok.SneakyThrows;
import vjvm.runtime.JClass;

import java.io.DataInput;

public class MethodRef extends Constant{
  public final int class_index;
  public final int name_and_type_index;
  public final JClass self;
  public String name;
  public String descriptor;
  public Boolean Judge;

  @SneakyThrows
  MethodRef(DataInput input, JClass thisClass, Boolean judge) {
    class_index = input.readUnsignedShort();
    name_and_type_index = input.readUnsignedShort();
    this.self = thisClass;
    Judge = judge;
  }

  public String Name() {
    if (name == null) {
      name = self.constantPool().constant(class_index).toString().substring(7);
    }
    return name;
  }

  public String descriptor() {
    if (descriptor == null) {
      descriptor = self.constantPool().constant(name_and_type_index).toString().substring(13);
    }
    return descriptor;
  }

  @Override
  public String toString() {
    if (Judge) {
      return String.format("Methodref: %s.%s", Name(), descriptor());
    }
    return String.format("InterfaceMethodref: %s.%s", Name(), descriptor());
  }
}
