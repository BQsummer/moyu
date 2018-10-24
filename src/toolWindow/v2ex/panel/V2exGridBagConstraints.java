package toolWindow.v2ex.panel;

import java.awt.*;

public class V2exGridBagConstraints extends GridBagConstraints {

    public V2exGridBagConstraints(int gridx, int gridy, int gridwidth, int gridheight) {
        super();
        this.fill = GridBagConstraints.BOTH;
        this.gridx = gridx;
        this.gridy = gridy;
        this.gridwidth = gridwidth;
        this.gridheight = gridheight;
    }

    public V2exGridBagConstraints(int gridx, int gridy, double weightx, double weighty) {
        super();
        this.fill = GridBagConstraints.BOTH;
        this.gridx = gridx;
        this.gridy = gridy;
        this.weightx = weightx;
        this.weighty = weighty;
    }
}
