package com.thaiopensource.relaxng.output.xsd.basic;

import com.thaiopensource.relaxng.edit.SourceLocation;

import java.util.List;

public class ParticleSequence extends ParticleGroup {
  public ParticleSequence(SourceLocation location, List children) {
    super(location, children);
  }

  public Object accept(ParticleVisitor visitor) {
    return visitor.visitSequence(this);
  }

  public boolean equals(Object obj) {
    return obj instanceof ParticleSequence && ((ParticleSequence)obj).getChildren().equals(getChildren());
  }
}
