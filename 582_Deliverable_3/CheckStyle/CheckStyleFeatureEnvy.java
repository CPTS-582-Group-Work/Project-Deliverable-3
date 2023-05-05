package testing;

import java.util.Arrays;
import java.util.List;

import com.puppycrawl.tools.checkstyle.api.AbstractCheck;
import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;

//package com.mycompany.checks;

import com.puppycrawl.tools.checkstyle.api.AbstractCheck;
import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;

public class CheckStyleFeatureEnvy extends AbstractCheck {

  private int maxMethodCalls = 5;
	
	 public CheckStyleFeatureEnvy() {
      // default constructor
  }

  public void setMaxMethodCalls(int maxMethodCalls) {
      this.maxMethodCalls = maxMethodCalls;
  }

  public int[] getDefaultTokens() {
      return new int[] { TokenTypes.METHOD_CALL };
  }

  public void visitToken(DetailAST ast) {
      DetailAST dot = ast.getFirstChild();
      if (dot.getType() == TokenTypes.DOT) {
          DetailAST identifier = dot.getLastChild();
          if (identifier.getType() == TokenTypes.IDENT) {
              String methodName = identifier.getText();
              if (methodName != null && !methodName.isEmpty()) {
                  DetailAST methodCall = ast.getParent();
                  int methodCallCount = countMethodCalls(methodCall, methodName);
                  if (methodCallCount > maxMethodCalls) {
                      log(ast.getLineNo(), "Feature Envy: Method " + methodName +
                          " is called " + methodCallCount + " times");
                  }
              }
          }
      }
  }

  private int countMethodCalls(DetailAST ast, String methodName) {
      int count = 0;
      for (DetailAST child = ast.getFirstChild(); child != null; child = child.getNextSibling()) {
          if (child.getType() == TokenTypes.METHOD_CALL) {
              DetailAST dot = child.getFirstChild();
              if (dot.getType() == TokenTypes.DOT) {
                  DetailAST identifier = dot.getLastChild();
                  if (identifier.getType() == TokenTypes.IDENT && methodName.equals(identifier.getText())) {
                      count++;
                  }
              }
          }
          count += countMethodCalls(child, methodName);
      }
      return count;
  }
	
	public int[] getRequiredTokens() {
		return new int[0];
	}
	@Override
	public int[] getAcceptableTokens() {
		return new int[] { TokenTypes.CLASS_DEF };
	}
	


}
