package com.thaiopensource.relaxng.output.xsd.basic;

import com.thaiopensource.relaxng.edit.SourceLocation;

public class GroupRef extends Particle {
  private final String name;

  public GroupRef(SourceLocation location, String name) {
    super(location);
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public Object accept(ParticleVisitor visitor) {
    return visitor.visitGroupRef(this);
  }

  public boolean equals(Object obj) {
    return obj instanceof GroupRef && name.equals(((GroupRef)obj).name);
  }

  public int hashCode() {
    return name.hashCode();
  }
}
