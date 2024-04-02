package vjvm.runtime.classdata.constant;

import lombok.SneakyThrows;
import lombok.var;
import vjvm.runtime.JClass;
import vjvm.runtime.classdata.MethodInfo;

import java.io.DataInput;

public class MethodRef extends Constant{
  private final int class_index;
  private final int name_and_type_index;
  private final JClass self;
  public String name;
  public String descriptor;
  public Boolean Judge;
  private MethodInfo method;
  private NameAndTypeConstant nameAndType;
  private ClassRef classRef;

  @SneakyThrows
  MethodRef(DataInput input, JClass thisClass, Boolean judge) {
    class_index = input.readUnsignedShort();
    name_and_type_index = input.readUnsignedShort();
    this.self = thisClass;
    Judge = judge;
  }

  public JClass jClass() {
    return classRef().value();
  }

  public ClassRef classRef() {
    if (classRef == null) {
      classRef = (ClassRef) self.constantPool().constant(class_index);
    }
    return classRef;
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

  private NameAndTypeConstant nameAndType() {
    if (nameAndType == null) {
      nameAndType =
        (NameAndTypeConstant) self.constantPool().constant(name_and_type_index);
    }
    return nameAndType;
  }

  public MethodInfo value() {
    if (method != null) {
      return method;
    }

    var pair = nameAndType().value();
    method = jClass().findMethod(nameAndType().name(), nameAndType().type());
    if (method == null) {
      throw new Error("No such method");
    }

    return method;
  }

  @Override
  public String toString() {
    if (Judge) {
      return String.format("Methodref: %s.%s", Name(), descriptor());
    }
    return String.format("InterfaceMethodref: %s.%s", Name(), descriptor());
  }
}
