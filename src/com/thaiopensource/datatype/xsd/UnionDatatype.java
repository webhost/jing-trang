package com.thaiopensource.datatype.xsd;

import com.thaiopensource.datatype.DatatypeContext;

class UnionDatatype extends DatatypeBase {
  private DatatypeBase type1;
  private DatatypeBase type2;
  
  UnionDatatype(DatatypeBase type1, DatatypeBase type2) {
    super(type1.getWhiteSpace() == type2.getWhiteSpace()
	  ? type1.getWhiteSpace()
	  : WHITE_SPACE_PRESERVE);
    if (type1.getWhiteSpace() != type2.getWhiteSpace()) {
      if (type1.getWhiteSpace() != WHITE_SPACE_PRESERVE)
	type1 = new TokenizedDatatype(type1);
      if (type2.getWhiteSpace() != WHITE_SPACE_PRESERVE)
	type2 = new TokenizedDatatype(type2);
    }
    this.type1 = type1;
    this.type2 = type2;
  }

  boolean lexicallyAllows(String str) {
    return type1.lexicallyAllows(str) || type2.lexicallyAllows(str);
  }

  boolean allowsValue(String str, DatatypeContext dc) {
    return ((type1.lexicallyAllows(str)
	     && type1.allowsValue(str, dc))
	    || (type2.lexicallyAllows(str)
		&& type2.allowsValue(str, dc)));
  }

  Object getValue(String str, DatatypeContext dc) {
    if (type1.lexicallyAllows(str)) {
      Object obj = type1.getValue(str, dc);
      if (obj != null)
	return obj;
    }
    if (type2.lexicallyAllows(str)) {
      Object obj = type2.getValue(str, dc);
      if (obj != null)
	return obj;
    }
    return null;
  }
}
