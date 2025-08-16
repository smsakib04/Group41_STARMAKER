package groupfortyone.group41_starmaker.Raghib;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class AppendableObjectOutputStreamCampaign extends ObjectOutputStream {
    public AppendableObjectOutputStreamCampaign(OutputStream out) throws IOException {
        super(out);
    }

    @Override
    protected void writeStreamHeader() throws IOException {
    }
}