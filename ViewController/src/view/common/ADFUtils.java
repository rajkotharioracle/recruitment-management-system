package view.common;


import java.util.Map;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.MethodExpression;
import javax.el.ValueExpression;

import javax.faces.context.FacesContext;

import oracle.adf.model.BindingContainer;
import oracle.adf.model.BindingContext;
import oracle.adf.model.DataControlFrame;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;


/**
 * Provides various utility methods that are handy to
 * have around when working with ADF.
 */
public class ADFUtils {

/**
* When a bounded task flow manages a transaction (marked as requires-transaction,.
* requires-new-transaction, or requires-existing-transaction), then the
* task flow must issue any commits or rollbacks that are needed. This is
* essentially to keep the state of the transaction that the task flow understands
* in synch with the state of the transaction in the ADFbc layer.
*
* Use this method to issue a commit in the middle of a task flow while staying
* in the task flow.
*/
public static void saveAndContinue() {
Map sessionMap =
FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
BindingContext context =
(BindingContext)sessionMap.get(BindingContext.CONTEXT_ID);
String currentFrameName = context.getCurrentDataControlFrame();
DataControlFrame dcFrame =
context.findDataControlFrame(currentFrameName);

dcFrame.commit();
dcFrame.beginTransaction(null);
}

/**
* Programmatic evaluation of EL.
*
* @param el EL to evaluate
* @return Result of the evaluation
*/
public static Object evaluateEL(String el) {
FacesContext facesContext = FacesContext.getCurrentInstance();
ELContext elContext = facesContext.getELContext();
ExpressionFactory expressionFactory =
facesContext.getApplication().getExpressionFactory();
ValueExpression exp =
expressionFactory.createValueExpression(elContext, el,
Object.class);

return exp.getValue(elContext);
}

/**
* Programmatic invocation of a method that an EL evaluates to.
* The method must not take any parameters.
*
* @param el EL of the method to invoke
* @return Object that the method returns
*/
public static Object invokeEL(String el) {
return invokeEL(el, new Class[0], new Object[0]);
}

/**
* Programmatic invocation of a method that an EL evaluates to.
*
* @param el EL of the method to invoke
* @param paramTypes Array of Class defining the types of the parameters
* @param params Array of Object defining the values of the parametrs
* @return Object that the method returns
*/
public static Object invokeEL(String el, Class[] paramTypes,
Object[] params) {
FacesContext facesContext = FacesContext.getCurrentInstance();
ELContext elContext = facesContext.getELContext();
ExpressionFactory expressionFactory =
facesContext.getApplication().getExpressionFactory();
MethodExpression exp =
expressionFactory.createMethodExpression(elContext, el,
Object.class, paramTypes);

return exp.invoke(elContext, params);
}


public static void setEL(String el, Object val) {
FacesContext facesContext = FacesContext.getCurrentInstance();
ELContext elContext = facesContext.getELContext();
ExpressionFactory expressionFactory =
facesContext.getApplication().getExpressionFactory();
ValueExpression exp =
expressionFactory.createValueExpression(elContext, el,
Object.class);

exp.setValue(elContext, val);
}
    public static DCIteratorBinding findIterator(String name) {
    DCIteratorBinding iter =
    getDCBindingContainer().findIteratorBinding(name);
    if (iter == null) {
    throw new RuntimeException("Iterator '" + name + "' not found");
    }
    return iter;
    }
    public static DCIteratorBinding findIterator(String bindingContainer, String iterator) {
    DCBindingContainer bindings =
    (DCBindingContainer)JSFUtils.resolveExpression("#{" + bindingContainer + "}");
    if (bindings == null) {
    throw new RuntimeException("Binding container '" +
    bindingContainer + "' not found");
    }
    DCIteratorBinding iter = bindings.findIteratorBinding(iterator);
    if (iter == null) {
    throw new RuntimeException("Iterator '" + iterator + "' not found");
    }
    return iter;
    }
    
    public static DCBindingContainer getDCBindingContainer() {
    return (DCBindingContainer)getBindingContainer();
    }
    public static BindingContainer getBindingContainer() {
    return (BindingContainer)JSFUtils.resolveExpression("#{bindings}");
    }

}