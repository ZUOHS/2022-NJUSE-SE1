package vjvm.runtime.classdata.constant;

import lombok.SneakyThrows;
import vjvm.runtime.JClass;

import java.io.DataInput;

public class FieldRef extends Constant{
  public final int class_index;
  public final int name_and_type_index;
  public final JClass self;
  public String name;
  public String descriptor;

  @SneakyThrows
  FieldRef(DataInput input, JClass thisClass) {
    class_index = input.readUnsignedShort();
    name_and_type_index = input.readUnsignedShort();
    this.self = thisClass;
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
    return String.format("Fieldref: %s.%s", Name(), descriptor());
  }
}
