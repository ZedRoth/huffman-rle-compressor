package test.com.harrycodeman;

import com.harrycodeman.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BytesRleCompressorTest {
    @Test
    public void testOneCharRepetitionCompress() throws Exception {
        BytesRleCompressor compressor = getCompressorForString("aaa");
        List<IBytesBlock> expected = new ArrayList<IBytesBlock>();
        expected.add(new SameBytesBlock((int)'a', 3));

        assertBlockListEquals(expected, compressor.compress());
    }

    @Test
    public void testTwoCharRepetitionCompress() throws Exception {
        BytesRleCompressor compressor = getCompressorForString("aaabb");
        List<IBytesBlock> expected = new ArrayList<IBytesBlock>();
        expected.add(new SameBytesBlock((int)'a', 3));
        expected.add(new SameBytesBlock((int)'b', 2));

        assertBlockListEquals(expected, compressor.compress());
    }

    @Test
    public void testOneCharCompress() throws Exception {
        BytesRleCompressor compressor = getCompressorForString("a");
        List<IBytesBlock> expected = new ArrayList<IBytesBlock>();
        expected.add(new SameBytesBlock((int)'a', 1));

        assertBlockListEquals(expected, compressor.compress());
    }

    @Test
    public void testDifferentLastCharCompress() throws Exception {
        BytesRleCompressor compressor = getCompressorForString("aaabbc");
        List<IBytesBlock> expected = new ArrayList<IBytesBlock>();
        expected.add(new SameBytesBlock((int) 'a', 3));
        expected.add(new SameBytesBlock((int) 'b', 2));
        expected.add(new SameBytesBlock((int)'c', 1));

        assertBlockListEquals(expected, compressor.compress());
    }

    @Test
    public void testDifferentCharsCompress() throws Exception {
        BytesRleCompressor compressor = getCompressorForString("abcabc");
        List<IBytesBlock> expected = new ArrayList<IBytesBlock>();
        DifferentBytesBlock differentBlock = new DifferentBytesBlock((int)'a', (int)'b');
        differentBlock.addSymbol((int)'c');
        differentBlock.addSymbol((int)'a');
        differentBlock.addSymbol((int)'b');
        differentBlock.addSymbol((int)'c');
        expected.add(differentBlock);

        assertBlockListEquals(expected, compressor.compress());
    }

    @Test
    public void testSameDifferentSameCharsCompress() throws Exception {
        BytesRleCompressor compressor = getCompressorForString("aaabcdeee");
        List<IBytesBlock> expected = new ArrayList<IBytesBlock>();
        expected.add(new SameBytesBlock((int)'a', 3));
        DifferentBytesBlock differentBlock = new DifferentBytesBlock((int)'b', (int)'c');
        differentBlock.addSymbol((int)'d');
        expected.add(differentBlock);
        expected.add(new SameBytesBlock((int)'e', 3));

        assertBlockListEquals(expected, compressor.compress());
    }

    @Test
    public void test130SameCharsCompress() throws Exception {
        BytesRleCompressor compressor = getCompressorForString("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        List<IBytesBlock> expected = new ArrayList<IBytesBlock>();
        expected.add(new SameBytesBlock((int)'a', 128));
        expected.add(new SameBytesBlock((int)'a', 2));

        assertBlockListEquals(expected, compressor.compress());
    }

    @Test
    public void test130DifferentCharsCompress() throws Exception {
        BytesRleCompressor compressor = getCompressorForString("qwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiopqwertyuiop");
        List<IBytesBlock> expected = new ArrayList<IBytesBlock>();
        DifferentBytesBlock differentBlock = new DifferentBytesBlock((int)'q', (int)'w');
        differentBlock.addSymbol((int)'e');
        differentBlock.addSymbol((int)'r');
        differentBlock.addSymbol((int)'t');
        differentBlock.addSymbol((int)'y');
        differentBlock.addSymbol((int)'u');
        differentBlock.addSymbol((int)'i');
        differentBlock.addSymbol((int)'o');
        differentBlock.addSymbol((int)'p');
        differentBlock.addSymbol((int)'q');
        differentBlock.addSymbol((int)'w');
        differentBlock.addSymbol((int)'e');
        differentBlock.addSymbol((int)'r');
        differentBlock.addSymbol((int)'t');
        differentBlock.addSymbol((int)'y');
        differentBlock.addSymbol((int)'u');
        differentBlock.addSymbol((int)'i');
        differentBlock.addSymbol((int)'o');
        differentBlock.addSymbol((int)'p');
        differentBlock.addSymbol((int)'q');
        differentBlock.addSymbol((int)'w');
        differentBlock.addSymbol((int)'e');
        differentBlock.addSymbol((int)'r');
        differentBlock.addSymbol((int)'t');
        differentBlock.addSymbol((int)'y');
        differentBlock.addSymbol((int)'u');
        differentBlock.addSymbol((int)'i');
        differentBlock.addSymbol((int)'o');
        differentBlock.addSymbol((int)'p');
        differentBlock.addSymbol((int)'q');
        differentBlock.addSymbol((int)'w');
        differentBlock.addSymbol((int)'e');
        differentBlock.addSymbol((int)'r');
        differentBlock.addSymbol((int)'t');
        differentBlock.addSymbol((int)'y');
        differentBlock.addSymbol((int)'u');
        differentBlock.addSymbol((int)'i');
        differentBlock.addSymbol((int)'o');
        differentBlock.addSymbol((int)'p');
        differentBlock.addSymbol((int)'q');
        differentBlock.addSymbol((int)'w');
        differentBlock.addSymbol((int)'e');
        differentBlock.addSymbol((int)'r');
        differentBlock.addSymbol((int)'t');
        differentBlock.addSymbol((int)'y');
        differentBlock.addSymbol((int)'u');
        differentBlock.addSymbol((int)'i');
        differentBlock.addSymbol((int)'o');
        differentBlock.addSymbol((int)'p');
        differentBlock.addSymbol((int)'q');
        differentBlock.addSymbol((int)'w');
        differentBlock.addSymbol((int)'e');
        differentBlock.addSymbol((int)'r');
        differentBlock.addSymbol((int)'t');
        differentBlock.addSymbol((int)'y');
        differentBlock.addSymbol((int)'u');
        differentBlock.addSymbol((int)'i');
        differentBlock.addSymbol((int)'o');
        differentBlock.addSymbol((int)'p');
        differentBlock.addSymbol((int)'q');
        differentBlock.addSymbol((int)'w');
        differentBlock.addSymbol((int)'e');
        differentBlock.addSymbol((int)'r');
        differentBlock.addSymbol((int)'t');
        differentBlock.addSymbol((int)'y');
        differentBlock.addSymbol((int)'u');
        differentBlock.addSymbol((int)'i');
        differentBlock.addSymbol((int)'o');
        differentBlock.addSymbol((int)'p');
        differentBlock.addSymbol((int)'q');
        differentBlock.addSymbol((int)'w');
        differentBlock.addSymbol((int)'e');
        differentBlock.addSymbol((int)'r');
        differentBlock.addSymbol((int)'t');
        differentBlock.addSymbol((int)'y');
        differentBlock.addSymbol((int)'u');
        differentBlock.addSymbol((int)'i');
        differentBlock.addSymbol((int)'o');
        differentBlock.addSymbol((int)'p');
        differentBlock.addSymbol((int)'q');
        differentBlock.addSymbol((int)'w');
        differentBlock.addSymbol((int)'e');
        differentBlock.addSymbol((int)'r');
        differentBlock.addSymbol((int)'t');
        differentBlock.addSymbol((int)'y');
        differentBlock.addSymbol((int)'u');
        differentBlock.addSymbol((int)'i');
        differentBlock.addSymbol((int)'o');
        differentBlock.addSymbol((int)'p');
        differentBlock.addSymbol((int)'q');
        differentBlock.addSymbol((int)'w');
        differentBlock.addSymbol((int)'e');
        differentBlock.addSymbol((int)'r');
        differentBlock.addSymbol((int)'t');
        differentBlock.addSymbol((int)'y');
        differentBlock.addSymbol((int)'u');
        differentBlock.addSymbol((int)'i');
        differentBlock.addSymbol((int)'o');
        differentBlock.addSymbol((int)'p');
        differentBlock.addSymbol((int)'q');
        differentBlock.addSymbol((int)'w');
        differentBlock.addSymbol((int)'e');
        differentBlock.addSymbol((int)'r');
        differentBlock.addSymbol((int)'t');
        differentBlock.addSymbol((int)'y');
        differentBlock.addSymbol((int)'u');
        differentBlock.addSymbol((int)'i');
        differentBlock.addSymbol((int)'o');
        differentBlock.addSymbol((int)'p');
        differentBlock.addSymbol((int)'q');
        differentBlock.addSymbol((int)'w');
        differentBlock.addSymbol((int)'e');
        differentBlock.addSymbol((int)'r');
        differentBlock.addSymbol((int)'t');
        differentBlock.addSymbol((int)'y');
        differentBlock.addSymbol((int)'u');
        differentBlock.addSymbol((int)'i');
        differentBlock.addSymbol((int)'o');
        differentBlock.addSymbol((int)'p');
        differentBlock.addSymbol((int)'q');
        differentBlock.addSymbol((int)'w');
        differentBlock.addSymbol((int)'e');
        differentBlock.addSymbol((int)'r');
        differentBlock.addSymbol((int)'t');
        differentBlock.addSymbol((int)'y');
        differentBlock.addSymbol((int)'u');
        differentBlock.addSymbol((int)'i');
        expected.add(differentBlock);
        differentBlock = new DifferentBytesBlock((int)'o', (int)'p');
        expected.add(differentBlock);
        assertBlockListEquals(expected, compressor.compress());
    }

    private BytesRleCompressor getCompressorForString(String s) {
        ICompressByteStream stream = new MemoryCompressByteStream(s);
        return new BytesRleCompressor(stream);
    }

    private void assertBlockListEquals(List<IBytesBlock> expected, List<IBytesBlock> actual) {
        // TODO: add check for symbols
        assertEquals(expected.size(), actual.size());
        int size = expected.size();
        for (int i = 0; i < size; i++) {
            assertEquals(expected.get(i).getClass(), actual.get(i).getClass());
            assertEquals(expected.get(i).size(), actual.get(i).size());
        }
    }
}