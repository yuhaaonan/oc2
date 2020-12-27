package li.cil.oc2.api.bus.device.vm;

import net.minecraft.util.text.ITextComponent;

import javax.annotation.Nullable;

/**
 * {@link VMDevice}s may signal the result of their {@link VMDevice#load(VMContext)} operations.
 */
public final class VMDeviceLoadResult {
    /**
     * Signals that the device was loaded successfully.
     *
     * @return a loading result signaling success.
     */
    public static VMDeviceLoadResult success() {
        return new VMDeviceLoadResult(true);
    }

    /**
     * Signals that the device failed loading.
     *
     * @return a loading result signaling failure.
     */
    public static VMDeviceLoadResult fail() {
        return new VMDeviceLoadResult(false);
    }

    private final boolean wasSuccessful;
    @Nullable private ITextComponent message;

    private VMDeviceLoadResult(final boolean wasSuccessful) {
        this.wasSuccessful = wasSuccessful;
    }

    /**
     * Whether the load operation was successful or not.
     *
     * @return {@code true} if the load was successful; {@code false} otherwise.
     */
    public boolean wasSuccessful() {
        return wasSuccessful;
    }

    /**
     * Adds an error message to this load result.
     * <p>
     * These messages should be very short to not overflow the area in which they are displayed.
     *
     * @param value the error message.
     * @return this load result, with the message set to the specified value.
     */
    public VMDeviceLoadResult withErrorMessage(final ITextComponent value) {
        message = value;
        return this;
    }

    /**
     * An optional error message on why the load failed.
     *
     * @return the error message.
     */
    @Nullable
    public ITextComponent getErrorMessage() {
        return message;
    }
}
