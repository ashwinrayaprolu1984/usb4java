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

package org.usb4java.jna;

import java.util.Arrays;
import java.util.List;

import com.sun.jna.Structure;
import com.sun.jna.Structure.ByReference;

/**
 * A collection of alternate settings for a particular USB interface.
 *
 * @author Klaus Reimer (k@ailis.de)
 */
public final class Interface extends Structure implements ByReference {
    /**
     * The array with interface descriptors. The length of this array is determined by the {@link #num_altsetting}
     * field.
     */
    public InterfaceDescriptor altsetting;

    /** the number of alternate settings that belong to this interface. */
    public int num_altsetting;

    @Override
    protected List getFieldOrder() {
        return Arrays.asList(new String[] { "altsetting", "num_altsetting" });
    }
}
