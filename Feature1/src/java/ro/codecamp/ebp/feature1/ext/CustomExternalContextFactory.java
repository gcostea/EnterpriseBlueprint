package ro.codecamp.ebp.feature1.ext;

import javax.faces.FacesException;
import javax.faces.context.ExternalContext;
import javax.faces.context.ExternalContextFactory;

public class CustomExternalContextFactory extends ExternalContextFactory 
{
    private ExternalContextFactory parent;

    public CustomExternalContextFactory (ExternalContextFactory parent)
    {
        super();
        this.parent = parent;
    }

    @Override
    public ExternalContext getExternalContext(Object context, Object request, Object response) throws FacesException 
    {
        return new CustomExternalContext(getWrapped().getExternalContext(context, request, response));
    }

    @Override
    public ExternalContextFactory getWrapped() 
    {
        return parent;
    }
}
