/*
 * Copyright 2013 Klaus Reimer <k@ailis.de>
 * See LICENSE.md for licensing information.
 *
 * Based on libusb <http://libusb.info/>:
 *
 * Copyright 2001 Johannes Erdfelt <johannes@erdfelt.com>
 * Copyright 2007-2009 Daniel Drake <dsd@gentoo.org>
 * Copyright 2010-2012 Peter Stuge <peter@stuge.se>
 * Copyright 2008-2013 Nathan Hjelm <hjelmn@users.sourceforge.net>
 * Copyright 2009-2013 Pete Batard <pete@akeo.ie>
 * Copyright 2009-2013 Ludovic Rousseau <ludovic.rousseau@gmail.com>
 * Copyright 2010-2012 Michael Plante <michael.plante@gmail.com>
 * Copyright 2011-2013 Hans de Goede <hdegoede@redhat.com>
 * Copyright 2012-2013 Martin Pieuchot <mpi@openbsd.org>
 * Copyright 2012-2013 Toby Gray <toby.gray@realvnc.com>
 */

package org.usb4java;

import com.sun.jna.Pointer;

/**
 * Structure representing a handle on a USB device.
 *
 * This is an opaque type for which you are only ever provided with a pointer, usually originating from
 * {@link LibUsb#open(Device, DeviceHandle)}.
 *
 * A device handle is used to perform I/O and other operations. When finished with a device handle, you should call
 * {@link LibUsb#close(DeviceHandle)}.
 *
 * @author Klaus Reimer (k@ailis.de)
 */
public final class DeviceHandle {
    /** The native pointer to the device handle structure. */
    private Pointer deviceHandlePointer;

    /**
     * Constructs a new device handle. Must be passed to {@link LibUsb#open(Device, DeviceHandle)} before passing it to
     * any other method.
     */
    public DeviceHandle() {
        // Empty
    }

    /**
     * Constructs a new device handle with the specified underlying native handle pointer.
     * 
     * @param deviceHandlePointer
     *            The native handle pointer.
     */
    public DeviceHandle(final Pointer deviceHandlePointer) {
        init(deviceHandlePointer);
    }

    void init(final Pointer deviceHandlePointer) {
        this.deviceHandlePointer = deviceHandlePointer;
    }

    /**
     * Returns the native pointer to the device handle structure.
     *
     * @return The native pointer to the device handle structure.
     */
    public Pointer getPointer() {
        return this.deviceHandlePointer;
    }

    @Override
    public int hashCode() {
        final long nativePointer = Pointer.nativeValue(this.deviceHandlePointer);
        final int prime = 31;
        int result = 1;
        result = (prime * result) + (int) (nativePointer ^ (nativePointer >>> 32));
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        final DeviceHandle other = (DeviceHandle) obj;
        if (Pointer.nativeValue(this.deviceHandlePointer) != Pointer.nativeValue(other.deviceHandlePointer)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format("libusb device handle 0x%x", Pointer.nativeValue(this.deviceHandlePointer));
    }
}
