package pages.frames_page.nested_frames_page;

import components.base_components.BaseComponent;
import components.base_components.FrameComponent;
import org.openqa.selenium.By;
import pages.BasePage;

public class NestedFramesPage extends BasePage {
    protected final String MIDDLE_FRAME_SET = ".//frame[@name='frame-top']";
    protected final String LEFT_FRAME = ".//frame[@name='frame-left']";
    protected final String MIDDLE_FRAME = ".//frame[@name='frame-middle']";
    protected final String RIGHT_FRAME = ".//frame[@src='/frame_right']";
    protected final String BOTTOM_FRAME = ".//frame[@name='frame-bottom']";
    protected final String MIDDLE_TEXT = ".//div[@id='content']";
    protected final String TEXT = ".//body";

    public String getVerificationURL() {
        return "nested_frames";
    }

    public FrameComponent middleFrameset() {
        return (FrameComponent) new FrameComponent().init(By.xpath(MIDDLE_FRAME_SET), this.webElement);
    }

    public FrameComponent leftFrame() {
        return (FrameComponent) new FrameComponent().init(By.xpath(LEFT_FRAME), this.webElement);
    }

    public FrameComponent middleFrame() {
        return (FrameComponent) new FrameComponent().init(By.xpath(MIDDLE_FRAME), this.webElement);
    }

    public FrameComponent rightFrame() {
        return (FrameComponent) new FrameComponent().init(By.xpath(RIGHT_FRAME), this.webElement);
    }

    public FrameComponent bottomFrame() {
        return (FrameComponent) new FrameComponent().init(By.xpath(BOTTOM_FRAME), this.webElement);
    }

    public BaseComponent middleText() {
        return new BaseComponent().init(By.xpath(MIDDLE_TEXT), this.webElement);
    }

    public BaseComponent text() {
        return new BaseComponent().init(By.xpath(TEXT), this.webElement);
    }
}
